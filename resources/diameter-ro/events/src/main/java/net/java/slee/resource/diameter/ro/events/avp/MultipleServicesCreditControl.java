/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package net.java.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp;

/**
 * Defines an interface representing the Multiple-Services-Credit-Control grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification:
 * <pre>
 * 7.1.4	Multiple-Services-Credit-Control
 * The Multiple-Services-Credit-Control AVP (AVP code 456) is of type grouped as specified in IETF RFC 4006 [402]. It contains additional 3GPP specific charging parameters.
 *
 *     It has the following ABNF grammar:
 *     <Multiple-Services-Credit-Control> ::=	   < AVP Header: 456 >
 *     			[ Granted-Service-Unit ]
 *     			[ Requested-Service-Unit ]
 *     			* [ Used-Service-Unit ]
 *     			* [ Service-Identifier ]	NOT IMPLEMENTED
 *     			[ Rating-Group ]
 *     			* [ G-S-U-Pool-Reference ]
 *     			[ Validity-Time ]
 *     			[ Result-Code ]
 *     			[ Final-Unit-Indication ]
 *     			[ Time-Quota-Threshold ]	NOT IMPLEMENTED
 *     			[ Volume-Quota-Threshold ]	NOT IMPLEMENTED
 *     			[ Unit-Quota-Threshold ]	NOT IMPLEMENTED
 *     			[ Quota-Holding-Time ]		NOT IMPLEMENTED
 *     			[ Quota-Consumption-Time ]	NOT IMPLEMENTED
 *     			* [ Reporting-Reason ]		NOT IMPLEMENTED
 *     			[ Trigger ]
 *     			[ PS-Furnish-Charging-Information ]	NOT IMPLEMENTED
 *     			[ Refund-Information ]		NOT IMPLEMENTED
 *     			* [ AF-Correlation-Information]	NOT IMPLEMENTED
 *     			* [ Envelope ]				NOT IMPLEMENTED
 *     			[ Envelope-Reporting ]		NOT IMPLEMENTED
 *     			[ Time-Quota-Mechanism ]	NOT IMPLEMENTED
 *     			* [ Service-Specific-Info ]
 *     			[ QoS-Information ]			NOT IMPLEMENTED
 *
 * </pre>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 * @author <a href="mailto:jacek.stromecki@pro-ids.com"> Jacek Stromecki [ProIDS] </a>
 */
public interface MultipleServicesCreditControl extends MultipleServicesCreditControlAvp {

	/**
	 * Returns the value of the Unit-Quota-Threshold AVP, of type Unsigned32.
	 *
	 * @return
	 */
	long getUnitQuotaThreshold();

	/**
	 * Returns the set of Service-Specific-Info AVPs. The returned array contains
	 * the AVPs in the order they appear in the message. A return value of null
	 * implies that no Service-Specific-Info AVPs have been set. <br>
	 * See: {@link ServiceSpecificInfo}.
	 *
	 * @return
	 */
	ServiceSpecificInfo[] getServiceSpecificInfos();

	/**
	 * Returns the value of the Trigger AVP, of type Grouped.
	 * Return value of null indicates that AVP has not been set. <br>
	 * See: {@link Trigger}
	 *
	 * @return
	 */
	Trigger getTrigger();


	/**
	 * Returns true if the Unit-Quota-Threshold AVP is present in the message.
	 *
	 * @return
	 */
	boolean hasUnitQuotaThreshold();

	/**
	 * Returns true if the Trigger AVP is present in the message.
	 *
	 * @return
	 */
	boolean hasTrigger();

	/**
	 * Sets the value of the Unit-Quota-Threshold AVP, of type Unsigned32.
	 *
	 * @param unitQuotaThreshold
	 */
	void setUnitQuotaThreshold(long unitQuotaThreshold);

	/**
	 * Sets a single Service-Specific-Info AVP in the message, of type Grouped. <br>
	 * See: {@link ServiceSpecificInfo}
	 *
	 * @param serviceSpecificInfo
	 */
	void setServiceSpecificInfo(ServiceSpecificInfo serviceSpecificInfo);

	/**
	 * Sets the set of Service-Specific-Info AVPs, with all the values in the given
	 * array. <br>
	 * See: {@link ServiceSpecificInfo}
	 *
	 * @param serviceSpecificInfos
	 */
	void setServiceSpecificInfos(ServiceSpecificInfo[] serviceSpecificInfos);

	/**
	 * Sets the value of the Trigger AVP, of type Grouped.
	 *
	 * @param trigger
	 */
	void setTrigger(Trigger trigger);

}
