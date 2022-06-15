package org.matsim.prepare;

import org.matsim.api.core.v01.TransportMode;
import org.matsim.api.core.v01.network.Network;
import org.matsim.core.network.NetworkUtils;

public class ChangeFreespeed {

    public static void main(String[] args) {

        var network = NetworkUtils.readNetwork("C:\\Users\\janek\\Desktop\\rvr-36-output\\metropole-ruhr-v1.0-10pct.output_network.xml.gz");

        changeNetwork(network);

        NetworkUtils.writeNetwork(network, "C:\\Users\\janek\\Desktop\\rvr-36-output\\matsim-class-seminar-7.xml.gz");
    }

    public static void changeNetwork(Network network) {
        for (var link : network.getLinks().values()) {

            if (link.getAllowedModes().contains(TransportMode.car))
                link.setFreespeed(10);
        }
    }
}
