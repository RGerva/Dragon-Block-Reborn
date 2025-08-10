const dialogues_data = [
  {
    id: "akira_toriyama_main_menu",
    npcId: "dbe:akira_toriyama",
    title: "ui.dbe.npcAkiraToriyama.title",
    body: [
      {
        text: "ui.dbe.npcAkiraToriyamaMain.evilText",
        requirements: {
          alignment: ["evil"]
        }
      },
      {
        text: "ui.dbe.npcAkiraToriyamaMain.neutralText",
        requirements: {
          alignment: ["neutral"]
        }
      },
      {
        text: "ui.dbe.npcAkiraToriyamaMain.goodText",
        requirements: {
          alignment: ["good"]
        }
      }
    ]
  },
  {
    id: "beerus_main_menu",
    npcId: "dbe:beerus",
    title: "ui.dbe.npcBeerus.title",
    body: [
      {
        text: "ui.dbe.npcBeerusMain.evilText",
        requirements: {
          alignment: ["evil"]
        }
      },
      {
        text: "ui.dbe.npcBeerusMain.neutralText",
        requirements: {
          alignment: ["neutral"]
        }
      },
      {
        text: "ui.dbe.npcBeerusMain.goodText",
        requirements: {
          alignment: ["good"]
        }
      }
    ],
    buttons: [
      {
        buttonText: "ui.dbe.npcBeerusMain.skillsButton",
        nextDialogue: "skills"
      }
    ],
    subMenus: [
      {
        id: "skills",
        title: "ui.dbe.npcBeerus.title",
        backButtonDialogue: "beerus_main_menu"
      }
    ]
  },
  {
    id: "mr_popo_main_menu",
    npcId: "dbe:mr_popo",
    title: "ui.dbe.npcMrPopo.title",
    body: [
      {
        text: "ui.dbe.npcMrPopoMain.evilText",
        requirements: {
          alignment: ["evil"]
        }
      },
      {
        text: "ui.dbe.npcMrPopoMain.neutralText",
        requirements: {
          alignment: ["neutral"]
        }
      },
      {
        text: "ui.dbe.npcMrPopoMain.goodText",
        requirements: {
          alignment: ["good"]
        }
      }
    ],
    buttons: [
      {
        buttonText: "ui.dbe.npcMrPopoMain.skillsButton",
        nextDialogue: "skills",
        requirements: {
          alignment: ["good", "neutral"]
        }
      }
    ],
    subMenus: [
      {
        id: "skills",
        title: "ui.dbe.npcMrPopo.title",
        backButtonDialogue: "mr_popo_main_menu"
      }
    ]
  },
  {
    id: "unigame_main_menu",
    npcId: "dbe:unigame",
    title: "ui.dbe.npcUnigame.title",
    addQuest: {
      questId: "pirate_robot_treasure",
      requirements: {
        alignment: ["good", "neutral"]
      }
    },
    body: [
      {
        text: "ui.dbe.npcUnigameMain.evilText",
        requirements: {
          alignment: ["evil"]
        }
      },
      {
        text: "ui.dbe.npcUnigameMain.neutralText",
        requirements: {
          alignment: ["neutral"]
        }
      },
      {
        text: "ui.dbe.npcUnigameMain.goodText",
        requirements: {
          alignment: ["good"]
        }
      }
    ]
  }
];
export {
  dialogues_data
};
