package edu.ems.domain.model.vob;

import edu.ems.domain.model.exception.BusinessRulesOnFieldsException;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.regex.Pattern;

@Getter
@ToString(includeFieldNames = false)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public final class Email {

    static final int MAX_LENGTH = 100;
    static final int MIN_LENGTH = 3;
    static final Pattern ALLOWED_CHARS = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    static final String EMAIL_FIELD = "email";


    @EqualsAndHashCode.Include
    String value;

    /**
     * Constructor privado. Use {@link #of(String)} para crear instancias.
     *
     * @param value valor ya validado del correo
     */
    private Email(String value) {
        this.value = value;
    }

    /**
     * Crea un nuevo {@link Email} validando las reglas de negocio.
     *
     * @param emailValue valor del correo a validar
     * @return instancia válida de {@link Email}
     */
    public static Email of(String emailValue) {
        return new Email(validate(emailValue));
    }

    /**
     * Valida el valor del correo según las reglas de negocio.
     *
     * @param emailValue valor a validar
     * @return el correo ya validado y normalizado
     */
    private static String validate(String emailValue) {
        if (emailValue == null || emailValue.isBlank()) {
            throw new BusinessRulesOnFieldsException(EMAIL_FIELD, "cannot be empty or null");
        }

        String email = emailValue.trim();


        if (email.length() > MAX_LENGTH || email.length() < MIN_LENGTH) {
            throw new BusinessRulesOnFieldsException(EMAIL_FIELD, "length must be between " + MIN_LENGTH + " and " + MAX_LENGTH);
        }

        if (!ALLOWED_CHARS.matcher(email).matches()) {
            throw new BusinessRulesOnFieldsException(EMAIL_FIELD, "invalid email format");
        }

        return email;
    }

}
