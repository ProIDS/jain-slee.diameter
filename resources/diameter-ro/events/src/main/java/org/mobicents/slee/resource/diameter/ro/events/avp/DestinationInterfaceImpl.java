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

import net.java.slee.resource.diameter.ro.events.avp.DestinationInterface;
import net.java.slee.resource.diameter.ro.events.avp.InterfaceType;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation of the Destination-Interface grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class DestinationInterfaceImpl extends GroupedAvpImpl implements DestinationInterface {

  public DestinationInterfaceImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public DestinationInterfaceImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }


    /**
     * Returns the value of the Interface-Id AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    public String getInterfaceId() {
        return getAvpAsUTF8String(DiameterRoAvpCodes.INTERFACE_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Interface-Text AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    public String getInterfaceText() {
        return getAvpAsUTF8String(DiameterRoAvpCodes.INTERFACE_TEXT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Interface-Port AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    public String getInterfacePort() {
        return getAvpAsUTF8String(DiameterRoAvpCodes.INTERFACE_PORT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Interface-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    public InterfaceType getInterfaceType() {
        return (InterfaceType) getAvpAsEnumerated(DiameterRoAvpCodes.INTERFACE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, InterfaceType.class);
    }

    /**
     * Returns true if the Interface-Id AVP is present in the message.
     */
    public boolean hasInterfaceId() {
        return hasAvp( DiameterRoAvpCodes.INTERFACE_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Interface-Text AVP is present in the message.
     */
    public boolean hasInterfaceText() {
        return hasAvp( DiameterRoAvpCodes.INTERFACE_TEXT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Interface-Port AVP is present in the message.
     */
    public boolean hasInterfacePort() {
        return hasAvp( DiameterRoAvpCodes.INTERFACE_PORT, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Interface-Type AVP is present in the message.
     */
    public boolean hasInterfaceType() {
        return hasAvp( DiameterRoAvpCodes.INTERFACE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Sets the value of the Interface-Id AVP, of type UTF8String.
     *
     * @param interfaceId
     */
    public void setInterfaceId(String interfaceId) {
        addAvp(DiameterRoAvpCodes.INTERFACE_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, interfaceId);
    }

    /**
     * Sets the value of the Interface-Text AVP, of type UTF8String.
     *
     * @param interfaceText
     */
    public void setInterfaceText(String interfaceText) {
        addAvp(DiameterRoAvpCodes.INTERFACE_TEXT, DiameterRoAvpCodes.TGPP_VENDOR_ID, interfaceText);
    }

    /**
     * Sets the value of the Interface-Port AVP, of type UTF8String.
     *
     * @param interfacePort
     */
    public void setInterfacePort(String interfacePort) {
        addAvp(DiameterRoAvpCodes.INTERFACE_PORT, DiameterRoAvpCodes.TGPP_VENDOR_ID, interfacePort);
    }

    /**
     * Sets the value of the Interface-Type AVP, of type Enumerated.
     *
     * @param interfaceType
     */
    public void setInterfaceType(InterfaceType interfaceType) {
        addAvp(DiameterRoAvpCodes.INTERFACE_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, interfaceType.getValue());
    }
}
