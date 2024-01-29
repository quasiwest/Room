package com.d209.childmade.room.repository;

import com.d209.childmade.room.entity.Room;
import com.d209.childmade.room.entity.RoomStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r " +
            "WHERE r.book.id = :bookId " +
            "AND r.roomStatus = com.d209.childmade.room.entity.RoomStatus.WAITING " +
            "AND NOT EXISTS (SELECT 1 FROM MemberRoom mr WHERE mr.room.id = r.id AND mr.role.id = :roleId) " +
            "ORDER BY r.createdAt ASC")
    List<Room> findRoom(Integer bookId, Integer roleId);



//    List<Room> findByBookIdAndRoomStatusOrderByCreatedAtAsc(Integer book_id,RoomStatus roomStatus);
    //책 고유번호로 맞는 방을 생성일자 오름차순으로 모두 조회, 방 시작여부는 WAITING

}
