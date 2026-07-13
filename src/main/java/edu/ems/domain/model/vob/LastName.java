package edu.ems.domain.model.vob;

import edu.ems.domain.model.exception.BusinessRulesOnFieldsException;

import java.util.regex.Pattern;

public record LastName(String value) {

    static final int MAX_LENGTH = 30;
    static final int MIN_LENGTH = 3;
    static final Pattern ALLOWED_CHARS = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9 .]+$");
    static final String LASTNAME_FIELD = "lastname";


    public LastName {
        validate(value);
        value = value.trim();
    }

    /**
     * Crea un nuevo {@link LastName} validando las reglas de negocio.
     *
     * @param value valor del apellido a validar
     * @return instancia válida de {@link LastName}
     */
    public static LastName of(String value) {
        return new LastName(value);
    }

    /**
     * Valida el valor del apellido según las reglas de negocio.
     *
     * @param inputName valor a validar
     * @return el apellido ya validado y normalizado
     */
    private static void validate(String inputName) {
        if (inputName == null || inputName.isBlank()) {
            throw new BusinessRulesOnFieldsException(LASTNAME_FIELD, "cannot be empty or null");
        }

        String name = inputName.trim();


        if (name.length() > MAX_LENGTH || name.length() < MIN_LENGTH) {
            throw new BusinessRulesOnFieldsException(LASTNAME_FIELD, "length must be between " + MIN_LENGTH + " and " + MAX_LENGTH);
        }

        if (!ALLOWED_CHARS.matcher(name).matches()) {
            throw new BusinessRulesOnFieldsException(LASTNAME_FIELD, "invalid lastname format");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
