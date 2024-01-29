package com.d209.childmade.room.service;

import com.d209.childmade.room.dto.request.RoomCreateRequestDto;
import com.d209.childmade.room.entity.Room;
import com.d209.childmade.room.repository.RoomRepository;
import io.openvidu.java.client.Connection;
import io.openvidu.java.client.ConnectionProperties;
import io.openvidu.java.client.OpenVidu;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import io.openvidu.java.client.Session;
import io.openvidu.java.client.SessionProperties;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    @Value("${openvidu.url}")
    private String OPENVIDU_URL;

    @Value("${openvidu.secret}")
    private String OPENVIDU_SECRET;

    private OpenVidu openvidu;
    @PostConstruct
    public void init() {
        this.openvidu = new OpenVidu(OPENVIDU_URL, OPENVIDU_SECRET);
    }

    public String roomCreate(int memberId, RoomCreateRequestDto roomCreateRequestDto)
            throws OpenViduJavaClientException, OpenViduHttpException {
        List<Room> findRoom = roomRepository.findRoom(
                roomCreateRequestDto.getBookId(), roomCreateRequestDto.getRoleId());
        if(!findRoom.isEmpty()){

            //동화와 역할에 맞는 Room이 존재하는 경우
            String sessionId = findRoom.get(0).getRoomSessionName();
            Session session = openvidu.getActiveSession(sessionId);

            //찾은 세션이 현재 사용되는 세션이아닐 경우 오류 처리

            //찾은 방 세션에 접근할 수 있는 토큰 발급 (메서드 만들자)
            Map<String, Object> params = new HashMap<>();
            ConnectionProperties properties = ConnectionProperties.fromJson(params).build();
            Connection connection = session.createConnection(properties);

            return connection.getToken();
        }
        else{
            //동화와 역할에 맞는 Room이 존재하지 않는 경우
            //memberId와 roleId, BookId를 이용해 세션을 만들고 방정보를 저장

            Map<String, Object> sessionParams = new HashMap<>();
            sessionParams.put("customSessionId",memberId+ roomCreateRequestDto.getBookId() + roomCreateRequestDto.getRoleId());
            SessionProperties sessionProperties = SessionProperties.fromJson(sessionParams).build();
            Session session = openvidu.createSession(sessionProperties);

            Map<String, Object> params = new HashMap<>();
            ConnectionProperties properties = ConnectionProperties.fromJson(params).build();
            Connection connection = session.createConnection(properties);
            return connection.getToken();
        }
    }
}
