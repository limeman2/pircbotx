/**
 * Copyright (C) 2010-2014 Leon Blakey <lord.quackstar at gmail.com>
 *
 * This file is part of PircBotX.
 *
 * PircBotX is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * PircBotX is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * PircBotX. If not, see <http://www.gnu.org/licenses/>.
 */
package org.pircbotx.hooks.events;

import com.google.common.collect.ImmutableMap;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.Event;

public class UserNoticeEvent extends Event {
    protected final String message;

    protected final String channelSource;

    protected final ImmutableMap<String, String> tags;

    public UserNoticeEvent(PircBotX bot, String channelSource, String message, ImmutableMap<String, String> tags) {
        super(bot);
        this.message = message;
        this.tags = tags;
        this.channelSource = channelSource;
    }

    @Override
	public void respond(String response) {
		respondWith(tags.get("login") + ": " + response);
	}

	public void respondWith(String fullLine) {
		getBot().sendIRC().message(channelSource, fullLine);
	}

	public ImmutableMap<String, String> getTags() {
        return this.tags;
    }

    public long getTimestamp() {
        return 0;
    }
}
