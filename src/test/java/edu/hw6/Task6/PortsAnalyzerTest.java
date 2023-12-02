package edu.hw6.Task6;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PortsAnalyzerTest {

    private final PortsAnalyzer portsAnalyzer = new PortsAnalyzer();

    @Test
    void analyze() {

        assertDoesNotThrow(portsAnalyzer::analyze);
        var portList = portsAnalyzer.analyze();
        assertFalse(portList.isEmpty());
        assertFalse(portList.stream().anyMatch(port->port.port()==22 && !port.info().equals("SSH")));
    }

    @Test
    void prettyPrintPortsInformationList() {
        assertDoesNotThrow(() -> portsAnalyzer.prettyPrintPortsInformationList(portsAnalyzer.analyze()));
        assertDoesNotThrow(() -> portsAnalyzer.prettyPrintPortsInformationList(List.of()));
    }
    @Test
    void infoTest() {
        var portList = portsAnalyzer.analyze();
        assertFalse(portList.stream().anyMatch(port->port.port()==22 && !port.info().equals("SSH")));
        assertFalse(portList.stream().anyMatch(port->port.port()==21 && !port.info().equals("FTP")));
        assertFalse(portList.stream().anyMatch(port->port.port()==25 && !port.info().equals("SMTP")));
        assertFalse(portList.stream().anyMatch(port->port.port()==53 && !port.info().equals("DNS")));
    }
}
