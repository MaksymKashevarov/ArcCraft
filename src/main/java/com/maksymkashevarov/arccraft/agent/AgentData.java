package com.maksymkashevarov.arccraft.agent;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class AgentData {

    public static final Codec<AgentData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("agent_name").forGetter(AgentData::getAgentName),
                    Codec.BOOL.fieldOf("authorized").forGetter(AgentData::isAuthorized)
            ).apply(instance, AgentData::new)
    );

    private String agentName = "";
    private boolean authorized = false;

    public AgentData() {
    }

    private AgentData(String agentName, boolean authorized) {
        this.agentName = agentName;
        this.authorized = authorized;
    }

    public String getAgentName() {
        return agentName;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void authorize() {
        if (isAuthorized()) {
            return;
        }
        authorized = true;
    }
}