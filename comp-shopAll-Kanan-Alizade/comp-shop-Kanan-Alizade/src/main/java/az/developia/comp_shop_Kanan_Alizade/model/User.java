package az.developia.comp_shop_Kanan_Alizade.model;


import jakarta.persistence.*;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Role role;
}

enum Role {
    SELLER,
    BUYER
}