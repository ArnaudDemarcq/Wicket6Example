package test;


import org.apache.wicket.protocol.http.WebApplication;

import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApplication extends WebApplication {

    private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public Class<Index> getHomePage() {
        return Index.class;
    }

    @Override
    protected void init() {
        // For Wicket
        super.init();
        // For Spring
        springInjection();
        // For GAE
        getResourceSettings().setResourcePollFrequency(null);
        // FOR DEBOUGS !
     //   getComponentPostOnBeforeRenderListeners().add(new WicketDebugListener());
    }




    protected void springInjection() {
      super.getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    } /**/
}
