package com.d209.childmade.room.repository;

import com.d209.childmade.room.entity.MemberRoom;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRoomRepository extends JpaRepository<MemberRoom, Long> {
//    Optional<MemberRoom> findByRoomIdAndRoleId(Long roomId, Integer roleId);
    //room_id를 통해서 사용자 방 정보에서 선택한 역할 정보가 있는 지 조회 -> 없어야 참여 가능함
}

