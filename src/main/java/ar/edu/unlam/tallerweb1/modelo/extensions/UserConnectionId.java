package ar.edu.unlam.tallerweb1.modelo.extensions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Sebastian on 02/06/2017.
 */
@Embeddable
public class UserConnectionId implements Serializable{
    @Column(nullable = false,length = 255,name="providerId")
    private String providerId;

    @Column(nullable = false,length = 255,name="providerUserId")
    private String providerUserId;

    @Column(nullable = false,length = 255,name="userId")
    private String userId;
}
