package br.com.denilo.ticketmanagementsystem.entities.enums;

public enum Priority {

    LOW (0, "ROLE_LOW"),
    MEDIUM (1, "ROLE_MEDIUM"),
    HIGH (2, "ROLE_HIGH");

    private Integer code;
    private String description;

    Priority(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(Integer code) {
        for (Priority x : Priority.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Código de prioridade inválido.");
    }
}
