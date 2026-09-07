package com.maksymkashevarov.arccraft.agent;


public class AgentInfo {
    public static String getInfo(AgentData agentData) {
        return "Agent Name: " + agentData.getAgentName()
                + " | Authorized: " + agentData.isAuthorized();
    }
}
