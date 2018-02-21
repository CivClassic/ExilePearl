package com.devotedmc.ExilePearl.command;

import com.devotedmc.ExilePearl.ExilePearl;
import com.devotedmc.ExilePearl.ExilePearlApi;
import com.devotedmc.ExilePearl.Lang;
import com.devotedmc.ExilePearl.PearlType;
import org.bukkit.WeatherType;

public class CmdKill extends PearlCommand {

	public CmdKill(ExilePearlApi pearlApi) {
		super(pearlApi);
		this.aliases.add("kill");
		
		this.senderMustBePlayer = true;
		this.setHelpShort("Kill a prisoner");
	}
	
	@Override
	public void perform() {
		ExilePearl pearl = plugin.getPearlFromItemStack(player().getInventory().getItemInMainHand());
		if(pearl == null) {
			msg(Lang.pearlMustBeHoldingPearl);
			return;
		}
		player().getWorld().strikeLightning(player().getLocation());
		player().damage(1000000.0); // should be enough
		player().setPlayerWeather(WeatherType.DOWNFALL);
		msg("<b>You tried to smite <c>%s<b>, but you smited yourself instead.",pearl.getPlayer());
		msg(pearl.getPlayer(), "<c>%s <g> tried to smite you, but smited themself instead.", player().getName());
		}
	}
}
