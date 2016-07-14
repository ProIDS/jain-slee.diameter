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

import net.java.slee.resource.diameter.ro.events.avp.AddressDomain;
import net.java.slee.resource.diameter.ro.events.avp.AddressType;
import net.java.slee.resource.diameter.ro.events.avp.OriginatorReceivedAddress;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation of the Originator-Received-Address grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class OriginatorReceivedAddressImpl extends GroupedAvpImpl implements OriginatorReceivedAddress {

  public OriginatorReceivedAddressImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public OriginatorReceivedAddressImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

    /**
     * Returns the value of the Address-Type AVP, of type Enumerated. A return value of null implies that the AVP has not been set.
     */
    public AddressType getAddressType() {
        return (AddressType) getAvpAsEnumerated(DiameterRoAvpCodes.ADDRESS_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, AddressType.class);
    }

    /**
     * Returns the value of the Address-Data AVP, of type UTF8String. A return value of null implies that the AVP has not been set.
     */
    public String getAddressData() {
        return getAvpAsUTF8String(DiameterRoAvpCodes.ADDRESS_DATA, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the Address-Domain AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    public AddressDomain getAddressDomain() {
        return (AddressDomain) getAvpAsCustom(DiameterRoAvpCodes.ADDRESS_DOMAIN, DiameterRoAvpCodes.TGPP_VENDOR_ID, AddressDomainImpl.class);
    }

    /**
     * Returns true if the Address-Type AVP is present in the message.
     */
    public boolean hasAddressType() {
        return hasAvp( DiameterRoAvpCodes.ADDRESS_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID );
    }

    /**
     * Returns true if the Address-Data AVP is present in the message.
     */
    public boolean hasAddressData() {
        return hasAvp( DiameterRoAvpCodes.ADDRESS_DATA, DiameterRoAvpCodes.TGPP_VENDOR_ID );
    }

    /**
     * Returns true if the Address-Domain AVP is present in the message.
     */
    public boolean hasAddressDomain() {
        return hasAvp( DiameterRoAvpCodes.ADDRESS_DOMAIN, DiameterRoAvpCodes.TGPP_VENDOR_ID );
    }

    /**
     * Sets the value of the Address-Type AVP, of type Enumerated.
     *
     * @param addressType
     */
    public void setAddressType(AddressType addressType) {
        addAvp(DiameterRoAvpCodes.ADDRESS_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, addressType.getValue());
    }

    /**
     * Sets the value of the Address-Data AVP, of type UTF8String.
     *
     * @param addressData
     */
    public void setAddressData(String addressData) {
        addAvp(DiameterRoAvpCodes.ADDRESS_DATA, DiameterRoAvpCodes.TGPP_VENDOR_ID, addressData);
    }

    /**
     * Sets the value of the Address-Domain AVP, of type Grouped.
     *
     * @param addressDomain
     */
    public void setAddressDomain(AddressDomain addressDomain) {
        addAvp(DiameterRoAvpCodes.ADDRESS_DOMAIN, DiameterRoAvpCodes.TGPP_VENDOR_ID, addressDomain.byteArrayValue());
    }
}
