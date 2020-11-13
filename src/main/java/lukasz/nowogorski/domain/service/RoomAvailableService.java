package lukasz.nowogorski.domain.service;

public interface RoomAvailableService {

    void getFreeRoom();
    void getBusyRoom(Long beds);
}
