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

import net.java.slee.resource.diameter.ro.events.avp.Trigger;
import net.java.slee.resource.diameter.ro.events.avp.TriggerType;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation of the Trigger grouped AVP type.<br>
 * <br>
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class TriggerImpl extends GroupedAvpImpl implements Trigger {

  public TriggerImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public TriggerImpl(int code, long vendorId, int mnd, int prt, byte[] value ) {
    super( code, vendorId, mnd, prt, value );
  }

    /**
     * Returns the set of Trigger-Type AVPs of type Enumerated. The returned array contains the AVPs in the order they appear in the message. A return value of null implies that no AVPs have been set.
     */
    public TriggerType[] getTriggerTypes() {
        return (TriggerType[]) getAvpsAsEnumerated(DiameterRoAvpCodes.TRIGGER_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, TriggerType.class);
    }

    /**
     * Sets the value of the Trigger-Type AVP, of type Enumerated.
     *
     * @param triggerType
     */
    public void setTriggerType(TriggerType triggerType) {
        addAvp(DiameterRoAvpCodes.TRIGGER_TYPE, DiameterRoAvpCodes.TGPP_VENDOR_ID, triggerType.getValue());
    }

    /**
     * Sets the set of Trigger-Type AVPs, with all the values in the given array. The AVPs will be added to message in the order in which they appear in the array.
     * Note: the array must not be altered by the caller following this call, and getTriggerTypes() is not guaranteed to return the same array instance, e.g. an "==" check would fail.
     *
     * @param triggerTypes
     */
    public void setTriggerTypes(TriggerType[] triggerTypes) {
        for(TriggerType triggerType : triggerTypes) {
            setTriggerType(triggerType);
        }
    }
}
