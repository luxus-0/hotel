package lukasz.nowogorski.service;

import lukasz.nowogorski.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

@Service
public class ReservationOnlineCreator {
    public ReservationOnline create(LocalDateTime checkIn, LocalDateTime checkOut) {
        return ReservationOnline.builder()
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();
    }

    public ReservationOnline create(ReservationOnline online) {

        return ReservationOnline.builder()
                .id(online.getId())
                .checkIn(online.getCheckIn())
                .checkOut(online.getCheckOut())
                .createdDate(online.getCreatedDate())
                .rooms(online.getRooms())
                .guests(online.getGuests())
                .build();
    }

    public ReservationOnline create() {

        return ReservationOnline.builder()
                .id(1L)
                .checkIn(getcheckIn())
                .checkOut(getCheckOut())
                .createdDate(createdDate())
                .rooms(Set.of(getRoom()))
                .guests(Set.of(getGuest()))
                .build();
    }

    public LocalDateTime getcheckIn()
    {
        return LocalDateTime.of(2000,Month.MARCH, 12, 12, 0);
    }

    public LocalDateTime getCheckOut()
    {
        return LocalDateTime.of(2000, Month.APRIL, 20, 12, 0);
    }

    LocalDateTime createdDate()
    {
        return LocalDateTime.now();
    }

    public ReservationOnline getReservationOnline()
    {
        return new ReservationOnline(1L,createdDate(),getcheckIn(),getCheckOut(),Set.of(getGuest()),Set.of(getRoom()));
    }

    public Guest getGuest()
    {
        return new Guest(1L,"Vitalij","Burtek","Vustok", Gender.MALE,5434242422L,"GB","+124234423223","ewrrwr@o2.pl","", LocalDate.of(2000,10,8),true,Set.of(getReservationOnline()));
    }

    public Room getRoom()
    {
        return new Room(1L,1,1,2,2,23.17F,"free", RoomType.STANDARD,getReservationOnline());
    }



}
