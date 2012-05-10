/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 *
 * @author arnaud
 */
public class Tracer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tracer.class);
    private String key;
    private String value;

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public final void init() {
        LOGGER.error("############################ KEY :<" + key +"> VALUE :<" + value + ">");
    }
}
