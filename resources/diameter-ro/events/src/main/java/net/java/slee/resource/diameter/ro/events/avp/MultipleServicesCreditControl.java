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
 * Defines an interface representing the Ro interface
 * Multiple-Services-Credit-Control grouped AVP type.<br>
 * <br>
 *
 * <Multiple-Services-Credit-Control> ::= < AVP Header: 456 >
 *											[ Unit-Quota-Threshold ]
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
	 * Returns true if the Unit-Quota-Threshold AVP is present in the message.
	 *
	 * @return
	 */
	boolean hasUnitQuotaThreshold();

	/**
	 * Sets the value of the Unit-Quota-Threshold AVP, of type Unsigned32.
	 *
	 * @param unitQuotaThreshold
	 */
	void setUnitQuotaThreshold(long unitQuotaThreshold);

}
