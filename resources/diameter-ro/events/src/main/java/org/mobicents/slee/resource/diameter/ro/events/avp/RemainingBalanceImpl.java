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

import net.java.slee.resource.diameter.cca.events.avp.CreditControlAVPCodes;
import net.java.slee.resource.diameter.cca.events.avp.UnitValueAvp;
import net.java.slee.resource.diameter.ro.events.avp.RemainingBalance;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;
import org.mobicents.slee.resource.diameter.cca.events.avp.UnitValueAvpImpl;

/**
 * Implementation of the Remaining-Balance grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class RemainingBalanceImpl extends GroupedAvpImpl implements RemainingBalance {

  public RemainingBalanceImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public RemainingBalanceImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

    /**
     * Returns the value of the Unit-Value AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    public UnitValueAvp getUnitValue() {
        return (UnitValueAvp) getAvpAsCustom(CreditControlAVPCodes.Unit_Value, UnitValueAvpImpl.class);

    }

    /**
     * Returns the value of the Currency-Code AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    public long getCurrencyCode() {
        return getAvpAsUnsigned32(CreditControlAVPCodes.Currency_Code);
    }

    /**
     * Returns true if the Unit-Value AVP is present in the message.
     */
    public boolean hasUnitValue() {
        return hasAvp( CreditControlAVPCodes.Unit_Value);
    }

    /**
     * Returns true if the Currency-Code AVP is present in the message.
     */
    public boolean hasCurrencyCode() {
        return hasAvp( CreditControlAVPCodes.Currency_Code );
    }

    /**
     * Sets the value of the Unit-Value AVP, of type Grouped.
     *
     * @param unitValue
     */
    public void setUnitValue(UnitValueAvp unitValue) {
        addAvp(CreditControlAVPCodes.Unit_Value, unitValue.byteArrayValue());
    }

    /**
     * Sets the value of the Currency-Code AVP, of type Unsigned32.
     *
     * @param currencyCode
     */
    public void setCurrencyCode(long currencyCode) {
        addAvp(CreditControlAVPCodes.Currency_Code, currencyCode);
    }

}
