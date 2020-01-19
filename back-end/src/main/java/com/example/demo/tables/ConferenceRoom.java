package com.example.demo.tables;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name="conference_room")
@Entity
public class ConferenceRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "location")
    public String location;
    @Column(name = "max_seats")
    public int max_seats;

    public ConferenceRoom(String name,String location, int max_seats) {
        this.name = name;
        this.location = location;
        this.max_seats = max_seats;
    }

    @Override
    public String toString() {
        return String.format("Room[id=%d, location='%s', max_seats='%s']", id, location, max_seats);
    }

}
