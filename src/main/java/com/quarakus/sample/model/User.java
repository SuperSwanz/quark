package com.quarakus.sample.model;

import com.quarakus.sample.dto.UserDTO;
import org.apache.commons.lang3.builder.EqualsBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user", indexes = {@Index(name = "INDX_USER_EMAIL", columnList = "email", unique = true)})
public class User extends Base {


    private static final long serialVersionUID = 7614467235438121578L;

    @NotEmpty
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @NotEmpty
    @Column(name = "last_name", length = 50)
    private String lastName;

    //@NotEmpty
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Email
    @NotEmpty
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        final User user = (User) obj;
        return new EqualsBuilder().append(this.email, user.getEmail()).isEquals();
    }

    public UserDTO toUserDTO() {
        final UserDTO userDTO = new UserDTO();
        userDTO.setEmail(this.email);
        userDTO.setFirstName(this.firstName);
        userDTO.setLastName(this.lastName);
        userDTO.setMiddleName(this.middleName);
        userDTO.setPhoneNumber(this.phoneNumber);
        return userDTO;
    }
}
