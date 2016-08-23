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
package org.mobicents.slee.resource.diameter.ro.events.avp;

import net.java.slee.resource.diameter.ro.events.avp.MultipleServicesCreditControl;
import net.java.slee.resource.diameter.ro.events.avp.ServiceSpecificInfo;
import org.mobicents.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvpImpl;

/**
 * Implementation of the Multiple-Services-Credit-Control grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 * @author <a href="mailto:jacek.stromecki@pro-ids.com"> Jacek Stromecki [ProIDS] </a>
 */
public class MultipleServicesCreditControlImpl extends MultipleServicesCreditControlAvpImpl implements MultipleServicesCreditControl {

	public MultipleServicesCreditControlImpl() {
		super();
	}

	/**
	 * @param code
	 * @param vendorId
	 * @param mnd
	 * @param prt
	 * @param value
	 */
	public MultipleServicesCreditControlImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
		super(code, vendorId, mnd, prt, value);
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see
	 * net.java.slee.resource.diameter.ro.events.avp.MultipleServicesCreditControl#getUnitQuotaThreshold()
	 */
	public long getUnitQuotaThreshold() {
		return getAvpAsUnsigned32(DiameterRoAvpCodes.UNIT_QUOTA_THRESHOLD);
	}

	/*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControl#getServiceSpecificInfos()
     */
	public ServiceSpecificInfo[] getServiceSpecificInfos() {
		return (ServiceSpecificInfo[]) getAvpsAsCustom(DiameterRoAvpCodes.SERVICE_SPECIFIC_INFO, ServiceSpecificInfoImpl.class);
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see
	 * net.java.slee.resource.diameter.ro.events.avp.MultipleServicesCreditControl#hasUnitQuotaThreshold()
	 */
	public boolean hasUnitQuotaThreshold() {
		return hasAvp(DiameterRoAvpCodes.UNIT_QUOTA_THRESHOLD);
	}

	/**
	 * (non-Javadoc)
	 *
	 * @see
	 * net.java.slee.resource.diameter.ro.events.avp.MultipleServicesCreditControl#setValidityTime(long)
	 */
	public void setUnitQuotaThreshold(long validityTime) {
		addAvp(DiameterRoAvpCodes.UNIT_QUOTA_THRESHOLD, validityTime);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp#setServiceSpecificInfo(net.java.slee.resource.diameter.cca.events.avp.ServiceSpecificInfo)
	 */
	public void setServiceSpecificInfo(ServiceSpecificInfo serviceSpecificInfo) {
		addAvp(DiameterRoAvpCodes.SERVICE_SPECIFIC_INFO, serviceSpecificInfo.byteArrayValue());
	}

	/*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.MultipleServicesCreditControlAvp#setServiceSpecificInfos(net.java.slee.resource.diameter.cca.events.avp.ServiceSpecificInfo[])
     */
	public void setServiceSpecificInfos(ServiceSpecificInfo[] serviceSpecificInfos) {
		for(ServiceSpecificInfo serviceSpecificInfo : serviceSpecificInfos) {
			setServiceSpecificInfo(serviceSpecificInfo);
		}
	}

}
