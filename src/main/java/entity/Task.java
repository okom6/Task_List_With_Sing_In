package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "priority")
    private Priority priority;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cathegory")
    private Cathegory cathegory;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user")
    private User user;

    private boolean isDone = false;

    public Task(Priority priority, Cathegory cathegory, User user) {
        this.priority = priority;
        this.cathegory = cathegory;
        this.user = user;
    }
}
