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

import net.java.slee.resource.diameter.base.events.avp.Address;
import net.java.slee.resource.diameter.ro.events.avp.DestinationInterface;
import net.java.slee.resource.diameter.ro.events.avp.RecipientAddress;
import net.java.slee.resource.diameter.ro.events.avp.RecipientInfo;
import net.java.slee.resource.diameter.ro.events.avp.RecipientReceivedAddress;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation of the Recipient-Info grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class RecipientInfoImpl extends GroupedAvpImpl implements RecipientInfo {

  public RecipientInfoImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public RecipientInfoImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

    /**
     * Returns the value of the Destination-Interface AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    public DestinationInterface getDestinationInterface() {
        return (DestinationInterface) getAvpAsCustom(DiameterRoAvpCodes.DESTINATION_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID, DestinationInterfaceImpl.class);

    }

    /**
     * Returns the set of Recipient-Address AVPs of type Grouped. The returned array contains the AVPs in the order they appear in the message. A return value of null implies that no AVPs have been set.
     */
    public RecipientAddress[] getRecipientAddresses() {
        return (RecipientAddress[]) getAvpsAsCustom(DiameterRoAvpCodes.RECIPIENT_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, RecipientAddressImpl.class);
    }

    /**
     * Returns the set of Recipient-Received-Address AVPs of type Grouped. The returned array contains the AVPs in the order they appear in the message.
     * A return value of null implies that no AVPs have been set.
     */
    public RecipientReceivedAddress[] getRecipientReceivedAddresses() {
        return (RecipientReceivedAddress[]) getAvpsAsCustom(DiameterRoAvpCodes.RECIPIENT_RECEIVED_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, RecipientReceivedAddressImpl.class);
    }

    /**
     * Returns the value of the Recipient-SCCP-Address AVP, of type Address. A return value of null implies that the AVP has not been set.
     */
    public Address getRecipientSccpAddress() {
        return getAvpAsAddress(DiameterRoAvpCodes.RECIPIENT_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns the value of the SM-Protocol-ID AVP, of type OctetString. A return value of null implies that the AVP has not been set.
     */
    public byte[] getSmProtocolId() {
        return getAvpAsOctetString(DiameterRoAvpCodes.SM_PROTOCOL_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID);
    }

    /**
     * Returns true if the Destination-Interface AVP is present in the message.
     */
    public boolean hasDestinationInterface() {
        return hasAvp( DiameterRoAvpCodes.DESTINATION_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID );
    }

    /**
     * Returns true if the Recipient-SCCP-Address AVP is present in the message.
     */
    public boolean hasRecipientSccpAddress() {
        return hasAvp( DiameterRoAvpCodes.RECIPIENT_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID );
    }

    /**
     * Returns true if the SM-Protocol-ID AVP is present in the message.
     */
    public boolean hasSmProtocolId() {
        return hasAvp( DiameterRoAvpCodes.SM_PROTOCOL_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID );
    }

    /**
     * Sets the value of the Destination-Interface AVP, of type Grouped.
     *
     * @param destinationInterface
     */
    public void setDestinationInterface(DestinationInterface destinationInterface) {
        addAvp(DiameterRoAvpCodes.DESTINATION_INTERFACE, DiameterRoAvpCodes.TGPP_VENDOR_ID, destinationInterface.byteArrayValue());
    }

    /**
     * Sets the value of the Recipient-Address AVP, of type Grouped.
     *
     * @param recipientAddress
     */
    public void setRecipientAddress(RecipientAddress recipientAddress) {
        addAvp(DiameterRoAvpCodes.RECIPIENT_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, recipientAddress.byteArrayValue());
    }

    /**
     * Sets the set of Recipient-Address AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getRecipientAddresses() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     *
     * @param recipientAddresses
     */
    public void setRecipientAddresses(RecipientAddress[] recipientAddresses) {
        for(RecipientAddress recipientAddress : recipientAddresses) {
            setRecipientAddress(recipientAddress);
        }
    }

    /**
     * Sets the value of the Recipient-Received-Address AVP, of type Grouped.
     *
     * @param recipientReceivedAddress
     */
    public void setRecipientReceivedAddress(RecipientReceivedAddress recipientReceivedAddress) {
        addAvp(DiameterRoAvpCodes.RECIPIENT_RECEIVED_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, recipientReceivedAddress.byteArrayValue());
    }

    /**
     * Sets the set of Recipient-Received-Address AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getRecipientReceivedAddresses() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     *
     * @param recipientReceivedAddresses
     */
    public void setRecipientReceivedAddresses(RecipientReceivedAddress[] recipientReceivedAddresses) {
        for(RecipientReceivedAddress recipientReceivedAddress : recipientReceivedAddresses) {
            setRecipientReceivedAddress(recipientReceivedAddress);
        }
    }

    /**
     * Sets the value of the Recipient-SCCP-Address AVP, of type Address.
     *
     * @param deliveryStatus
     */
    public void setRecipientSccpAddress(Address deliveryStatus) {
        addAvp(DiameterRoAvpCodes.RECIPIENT_SCCP_ADDRESS, DiameterRoAvpCodes.TGPP_VENDOR_ID, deliveryStatus.encode());
    }

    /**
     * Sets the value of the SM-Protocol-ID AVP, of type OctetString.
     *
     * @param smProtocolId
     */
    public void setSmProtocolId(byte[] smProtocolId) {
        addAvp(DiameterRoAvpCodes.SM_PROTOCOL_ID, DiameterRoAvpCodes.TGPP_VENDOR_ID, smProtocolId);
    }
}
