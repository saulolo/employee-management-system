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
public final class Name {

    static final int MAX_LENGTH = 30;
    static final int MIN_LENGTH = 3;
    static final Pattern ALLOWED_CHARS = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9 .]+$");
    static final String NAME_FIELD = "name";


    @EqualsAndHashCode.Include
    String value;

    /**
     * Constructor privado. Use {@link #of(String)} para crear instancias.
     *
     * @param value valor ya validado del nombre
     */
    private Name(String value) {
        this.value = value;
    }

    /**
     * Crea un nuevo {@link Name} validando las reglas de negocio.
     *
     * @param value valor del nombre a validar
     * @return instancia válida de {@link Name}
     */
    public static Name of(String value) {
        return new Name(validate(value));
    }

    /**
     * Valida el valor del nombre según las reglas de negocio.
     *
     * @param inputName valor a validar
     * @return el nombre ya validado y normalizado
     */
    private static String validate(String inputName) {
        if (inputName == null || inputName.isBlank()) {
            throw new BusinessRulesOnFieldsException(NAME_FIELD, "cannot be empty or null");
        }

        String name = inputName.trim();


        if (name.length() > MAX_LENGTH || name.length() < MIN_LENGTH) {
            throw new BusinessRulesOnFieldsException(NAME_FIELD, "length must be between " + MIN_LENGTH + " and " + MAX_LENGTH);
        }

        if (!ALLOWED_CHARS.matcher(name).matches()) {
            throw new BusinessRulesOnFieldsException(NAME_FIELD, "invalid name format");
        }

        return name;
    }

}
