package org.gsr.javabrains;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IpLocationFinder {

	public static void main(String[] args) {
		System.out.println("Args  length : " + args.length + " and ip address is " + args[0]);
		if(args.length!= 1)
		{
			System.out.println("you need to passin only one IP Address");
		}
		else {
			
			String ipAdress = args[0];
			GeoIPService ipservice = new GeoIPService();
			GeoIPServiceSoap geoIpServicesoap = ipservice.getGeoIPServiceSoap();
			GeoIP geoIp = geoIpServicesoap.getGeoIP(ipAdress);
			System.out.println(geoIp.getCountryName()) ;
		}
		
	}

}
  