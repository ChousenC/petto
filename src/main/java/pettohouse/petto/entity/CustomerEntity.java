package pettohouse.petto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Entity
public class Customer extends BaseTimeEntity {

    public static final String MALE = "M";

    public static final String FEMALE = "F";

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private char gender;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String pwssword;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "address")
    private String address;

    public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public void setBirthday(Date birthday) {
        if (birthday != null) {
            // 將 birthday 轉為字串
            String date = birthday.toString();
            date = date.replace("/", "-");
            try {
                Date d = df.parse(date);
                this.setBirthday(d);
            } catch (ParseException e) {
                throw new RuntimeException("生日日期格式不正確：" + birthday, e);
            }
        } else {
            Date d  = null;
            this.setBirthday(d);
        }
    }



}
