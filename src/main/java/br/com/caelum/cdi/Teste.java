package br.com.caelum.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class Teste {

    public static void main(String[] args) {

        final WeldContainer container = new Weld().initialize();
    }
}

class OlaMundo {

    public void sayHi() {

        System.out.println("Oi!");
    }
}

class Main {

    private final OlaMundo olaMundo;

    @Inject
    Main(OlaMundo olaMundo) {
        this.olaMundo = olaMundo;
    }

    public void startup(@Observes ContainerInitialized event) {
        olaMundo.sayHi();
    }
}