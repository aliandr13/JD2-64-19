package by.it.academy.entity.Homework_Relation;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "MEETING")
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID")
    private Long meetingID;
    private String subject;
    private LocalDateTime startDate;

    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet<>();

    public Meeting(String subject) {
        this.subject = subject;
        this.startDate = LocalDateTime.now();
    }
}
