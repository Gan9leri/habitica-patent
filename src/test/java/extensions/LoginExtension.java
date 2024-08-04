package extensions;

import authorization.Authorization;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoginExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) throws JsonProcessingException {
        Authorization.setAuthDataInLocalStorage(Authorization.getAuthResponse());
    }
}
