package gameElements.levelAndContents.npc;

public class NPCFactory {
    public static NPC getNPC(String npcType) {
        if (npcType == null) {
            return null;
        }

        if (npcType.equalsIgnoreCase("FRIENDLYNPC")) {
            return new FriendlyNPC();
        } else if (npcType.equalsIgnoreCase("ENEMYNPC")) {
            return new EnemyNPC();
        }

        return null;
    }
}