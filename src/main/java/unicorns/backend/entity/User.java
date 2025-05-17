package unicorns.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import unicorns.backend.util.Schema;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = Schema.BACKEND_APP)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    String username;
    String password;
    String email;
    String name;
    LocalDateTime lastLogin;
    LocalDateTime dateOfBirth;
    LocalDateTime passExpireTime;
    Boolean changeFirstPass;
    Integer countFail;
    Integer status;
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getPassExpireTime() {
        return passExpireTime;
    }

    public void setPassExpireTime(LocalDateTime passExpireTime) {
        this.passExpireTime = passExpireTime;
    }

    public Integer getCountFail() {
        return countFail;
    }

    public void setCountFail(Integer countFail) {
        this.countFail = countFail;
    }

    public Boolean getChangeFirstPass() {
        return changeFirstPass;
    }

    public void setChangeFirstPass(Boolean changeFirstPass) {
        this.changeFirstPass = changeFirstPass;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
