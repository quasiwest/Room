package com.d209.childmade.room.controller;

import com.d209.childmade.room.dto.request.RoomCreateRequestDto;
import com.d209.childmade.room.service.RoomService;
import io.openvidu.java.client.OpenViduHttpException;
import io.openvidu.java.client.OpenViduJavaClientException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    /*

     */

    @PostMapping("/{member_id}")
    public ResponseEntity<String>  roomCreate(@PathVariable("member_id") int memberId){
        System.out.println("memberId = " + memberId);
        return new ResponseEntity<>(String.valueOf(memberId), HttpStatus.OK);
    }


    @PutMapping("/{member_id}")
    public ResponseEntity<String>  roomCreate(@PathVariable("member_id") int memberId, @RequestBody RoomCreateRequestDto roomCreateRequestDto)
            throws OpenViduJavaClientException, OpenViduHttpException {
        System.out.println("memberId = " + memberId);
        String result =  roomService.roomCreate(memberId,roomCreateRequestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
