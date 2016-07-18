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

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;
import net.java.slee.resource.diameter.cca.events.avp.UnitValueAvp;

/**
 * Defines an interface representing the Remaining-Balance grouped AVP type.<br>
 * <br>
 * From the Diameter Ro Reference Point Protocol Details (3GPP TS 32.299 V8.25.0) specification:
 * <pre>
 * 7.2.133	Remaining-Balance AVP
 *  The Remaining-Balance AVP (AVPcode 2021) is of type Grouped and provides information about the remaining account balance of the subscriber.
 *     It has the following ABNF grammar:
 *    Remaining-Balance :: = 	< AVP Header: 2021 >
 *
 *         { Unit-Value }
 *         { Currency-Code }
 * </pre>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public interface RemainingBalance extends GroupedAvp {

    /**
     * Returns the value of the Unit-Value AVP, of type Grouped. A return value of null implies that the AVP has not been set.
     */
    abstract UnitValueAvp getUnitValue();

    /**
     * Returns the value of the Currency-Code AVP, of type Unsigned32. A return value of null implies that the AVP has not been set.
     */
    abstract long getCurrencyCode();


    /**
     * Returns true if the Unit-Value AVP is present in the message.
     */
    abstract boolean hasUnitValue();

    /**
     * Returns true if the Currency-Code AVP is present in the message.
     */
    abstract boolean hasCurrencyCode();

    /**
     * Sets the value of the Unit-Value AVP, of type Grouped.
     */
    abstract void setUnitValue(UnitValueAvp unitValue);

    /**
     * Sets the value of the Currency-Code AVP, of type Unsigned32.
     */
    abstract void setCurrencyCode(long currencyCode);

}
