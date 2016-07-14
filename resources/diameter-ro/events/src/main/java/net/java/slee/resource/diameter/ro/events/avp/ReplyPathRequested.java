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

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.StreamCorruptedException;

/**
 * Java class to represent the ReplyPathRequested enumerated type.
 *
 * @author <a href="mailto:grzegorz.figiel@pro-ids.com"> Grzegorz Figiel [ProIDS] </a>
 */
public class ReplyPathRequested implements Enumerated, java.io.Serializable {

    private static final long serialVersionUID = 1L;

    public static final int _NO_REPLY_PATH_SET = 0;
    public static final int _REPLY_PATH_SET = 1;

    public static final ReplyPathRequested NO_REPLY_PATH_SET = new ReplyPathRequested(_NO_REPLY_PATH_SET);
    public static final ReplyPathRequested REPLY_PATH_SET = new ReplyPathRequested(_REPLY_PATH_SET);

    private ReplyPathRequested(int v) {
        value = v;
    }

    /**
     * Return the value of this instance of this enumerated type.
     */
    public static ReplyPathRequested fromInt(int type) {
        switch (type) {
            case _NO_REPLY_PATH_SET:
                return NO_REPLY_PATH_SET;
            case _REPLY_PATH_SET:
                return REPLY_PATH_SET;

            default:
                throw new IllegalArgumentException("Invalid ReplyPathRequested value: " + type);
        }
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        switch (value) {
            case _NO_REPLY_PATH_SET:
                return "NO_REPLY_PATH_SET";
            case _REPLY_PATH_SET:
                return "REPLY_PATH_SET";

            default:
                return "<Invalid Value>";
        }
    }

    private Object readResolve() throws StreamCorruptedException {
        try {
            return fromInt(value);
        } catch (IllegalArgumentException iae) {
            throw new StreamCorruptedException("Invalid internal state found: " + value);
        }
    }

    private int value = 0;

}
