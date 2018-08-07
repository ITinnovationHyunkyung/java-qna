package codesquad.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, unique = true, nullable = false)
    private String userId;
    @Column(length = 10, nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String name;
    private String email;


    public User() {

    }

    public User(Long id, String userId, String password, String name, String email) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPW(String password) {
        this.password = password;
    }

    public void setNickname(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSameUser(User user) {
        if(user == null)
            return false;
        return this.id.equals(user.getId());
    }

    public boolean isSamePassword(String password) {
        return this.password.equals(password);
    }

    public void updateUser(User updated) {
        if (!isSamePassword(updated.password))
            return;
        this.name = updated.name;
        this.password = updated.password;
        this.email = updated.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, password, name, email);
    }

}
