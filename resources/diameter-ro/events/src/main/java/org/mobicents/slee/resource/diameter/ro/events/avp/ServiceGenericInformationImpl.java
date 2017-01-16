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

import net.java.slee.resource.diameter.ro.events.avp.ApplicationServiceType;
import net.java.slee.resource.diameter.ro.events.avp.ServiceGenericInformation;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation of the Destination-Interface grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class ServiceGenericInformationImpl extends GroupedAvpImpl implements ServiceGenericInformation {

  public ServiceGenericInformationImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public ServiceGenericInformationImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

    /**
     * Returns the value of the Application-Server-ID AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    public long getApplicationServerID() {
        return getAvpAsUnsigned32(DiameterRoAvpCodes.APPLICATION_SERVER_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Application-Service-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    public ApplicationServiceType getApplicationServiceType() {
        return (ApplicationServiceType) getAvpAsEnumerated(DiameterRoAvpCodes.APPLICATION_SERVICE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, ApplicationServiceType.class);
    }

    /**
     * Returns the value of the Application-Session-ID AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    public long getApplicationSessionId() {
        return getAvpAsUnsigned32(DiameterRoAvpCodes.APPLICATION_SESSION_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Delivery-Status AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    public String getDeliveryStatus() {
        return getAvpAsUTF8String(DiameterRoAvpCodes.DELIVERY_STATUS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Application-Server-ID AVP is present in the message.
     */
    public boolean hasApplicationServerId() {
        return hasAvp( DiameterRoAvpCodes.APPLICATION_SERVER_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Application-Service-Type AVP is present in the message.
     */
    public boolean hasApplicationServiceType() {
        return hasAvp( DiameterRoAvpCodes.APPLICATION_SERVICE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Application-Session-ID AVP is present in the message.
     */
    public boolean hasApplicationSessionId() {
        return hasAvp( DiameterRoAvpCodes.APPLICATION_SESSION_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Delivery-Status AVP is present in the message.
     */
    public boolean hasDeliveryStatus() {
        return hasAvp( DiameterRoAvpCodes.DELIVERY_STATUS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Sets the value of the Application-Server-ID AVP, of type Unsigned32.
     *
     * @param applicationServerId
     */
    public void setApplicationServerId(long applicationServerId) {
        addAvp(DiameterRoAvpCodes.APPLICATION_SERVER_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, applicationServerId);
    }

    /**
     * Sets the value of the Application-Service-Type AVP, of type Enumerated.
     *
     * @param applicationServiceType
     */
    public void setApplicationServiceType(ApplicationServiceType applicationServiceType) {
        addAvp(DiameterRoAvpCodes.APPLICATION_SERVICE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, applicationServiceType.getValue());
    }

    /**
     * Sets the value of the Application-Session-ID AVP, of type Unsigned32.
     *
     * @param applicationSessionId
     */
    public void setApplicationSessionId(long applicationSessionId) {
        addAvp(DiameterRoAvpCodes.APPLICATION_SESSION_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, applicationSessionId);
    }

    /**
     * Sets the value of the Delivery-Status AVP, of type UTF8String.
     *
     * @param deliveryStatus
     */
    public void setDeliveryStatus(String deliveryStatus) {
        addAvp(DiameterRoAvpCodes.DELIVERY_STATUS, DiameterRoAvpCodes.TGPP_VENDOR_ID, deliveryStatus);
    }
}
