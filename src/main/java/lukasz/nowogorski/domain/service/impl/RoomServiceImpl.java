package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Room;
import lukasz.nowogorski.domain.model.RoomStandard;
import lukasz.nowogorski.domain.model.RoomType;
import lukasz.nowogorski.domain.service.RoomService;
import lukasz.nowogorski.infrastructure.postgres.RoomRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
final class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;

    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Room> findRoom() {
        return repository.findAll();
    }

    @Override
    public Room findRoomById(Long id) {
        Optional<Room> roomOptional = repository.findById(id);
        return roomOptional.orElseThrow(() -> new EntityNotFoundException("No room with such id: " +id));
    }

    @Override
    public List<Room> findRoomByRoomNumber(Long roomNumber) {
        return repository.findByRoomNumber(roomNumber);
    }

    @Override
    public List<Room> findRoomByFloor(Long floor) {
        return repository.findByFloor(floor);
    }

    @Override
    public List<Room> findRoomByBeds(Long beds) {
        return repository.findByBeds(beds);
    }

    @Override
    public List<Room> findRoomByPeopleNumber(Long peopleNumber) {
        return repository.findByPeopleNumber(peopleNumber);
    }

    @Override
    public List<Room> findRoomByRoomStandard(RoomStandard roomStandard) {
        return repository.findByRoomStandard(roomStandard);
    }

    @Override
    public List<Room> findRoomByPriceForNight(Float priceForNight) {
        return repository.findByPriceForNight(priceForNight);
    }

    @Override
    public List<Room> findRoomByRoomType(RoomType roomType) {
        return repository.findByRoomType(roomType);
    }

    @Override
    public List<Room> findRoomByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public Room saveRoom(Room room) {
        return repository.save(room);
    }

    @Override
    public Room updateRoom(Room room, Long id) {
        return repository.update(room, id);
    }

    @Override
    public void deleteRoom() {
        repository.deleteAll();
    }

    @Override
    public void deleteRoomById(Long id) {
        repository.deleteById(id);
    }
}
