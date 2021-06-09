package org.larma.errors;

import org.larma.model.PostnrInfo;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidationException extends RuntimeException {
    private final Set<ConstraintViolation<PostnrInfo>> violations;

    public ValidationException(
            final Set<ConstraintViolation<PostnrInfo>> violations)
    {
        super("Validation exception");
        this.violations = violations;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder("[");
        for (ConstraintViolation<PostnrInfo> v : violations) {
            if (sb.length() > 2) {
                sb.append(",");
            }
            sb.append("{");
            sb.append("\"property\": \"").append(v.getPropertyPath()).append("\"").append(",");
            sb.append("\"message\": \"").append(v.getMessage()).append("\"");
            sb.append("}");
        }
        sb.append("]");
        return sb.toString();
    }
}
