package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("MagicNumber")
public class PortsAnalyzer {
    private final static Logger LOGGER = LogManager.getLogger();

    public List<PortsInformation> analyze() {
        List<PortsInformation> unallocatedPorts = new ArrayList<>();
        for (int port = 1; port < 49151; port++) {
            if (!isEmptyTCP(port)) {
                unallocatedPorts.add(new PortsInformation(Protocol.TCP, port, getPortsInfo(port)));
            }
            if (!isEmptyUDP(port)) {
                unallocatedPorts.add(new PortsInformation(Protocol.UDP, port, getPortsInfo(port)));
            }
        }
        return unallocatedPorts;
    }

    public void prettyPrintPortsInformationList(List<PortsInformation> list) {
        if (list.isEmpty()) {
            LOGGER.info("no ports");
        } else {

            LOGGER.info("Протокол,  Порт,   Сервис");
            list.forEach(LOGGER::info);
        }

    }

    private boolean isEmptyUDP(int port) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            return true;
        } catch (SocketException e) {
            return false;
        }
    }

    private boolean isEmptyTCP(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private String getPortsInfo(int port) {
        return switch (port) {
            case 21 -> "FTP";
            case 25 -> "SMTP";
            case 22 -> "SSH";
            case 53 -> "DNS";
            case 80 -> "HTTP";
            case 443 -> "HTTPS";
            case 5353 -> "mDNS";
            case 110 -> "POP3";
            default -> "";
        };
    }

    public enum Protocol {
        TCP, UDP;

        @Override
        public String toString() {
            return this.name();
        }
    }

    public record PortsInformation(Protocol protocol, int port, String info) {
        @Override
        public String toString() {
            return protocol + " " + port + " " + info;
        }
    }
}
