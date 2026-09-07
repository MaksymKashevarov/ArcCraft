package com.maksymkashevarov.arccraft.agent;

public class AgentData {

    private String agentName = "";
    private boolean authorized = false;

    public String getAgentName() {
        return agentName;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void authorize(){
        if (isAuthorized()){
            return;
        }
        authorized = true;
    }
}