package org.apereo.cas.adaptors.trusted.authentication.handler.support;

import org.apereo.cas.adaptors.trusted.authentication.principal.PrincipalBearingCredential;
import org.apereo.cas.authentication.credential.UsernamePasswordCredential;
import org.apereo.cas.authentication.principal.DefaultPrincipalFactory;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Andrew Petro
 * @since 3.0.0
 */
public class PrincipalBearingCredentialsAuthenticationHandlerTests {

    private final PrincipalBearingCredentialsAuthenticationHandler handler = new PrincipalBearingCredentialsAuthenticationHandler("", null, null);

    /**
     * When the credentials bear a Principal, succeed the authentication.
     */
    @Test
    public void verifyNonNullPrincipal() {
        val credentials = new PrincipalBearingCredential(new DefaultPrincipalFactory().createPrincipal("scott"));
        assertNotNull(this.handler.authenticate(credentials));
    }

    @Test
    public void verifySupports() {
        val credentials = new PrincipalBearingCredential(new DefaultPrincipalFactory().createPrincipal("scott"));
        assertTrue(this.handler.supports(credentials));
        assertFalse(this.handler.supports(new UsernamePasswordCredential()));
    }
}
