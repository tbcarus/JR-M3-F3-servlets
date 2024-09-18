package ru.tbcarus.quest.util;

public class Constants {

    public static final String QUESTS_MAP_YAML = "C:/projects/JR/Module-3/JR-M3-F3-servlets/src/main/resources/QuestsMap.yaml";

    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";


    // paths
    public static final String PATH_ROOT = "/";
    public static final String PATH_BAN = "/ban";
    public static final String PATH_START = "/start";
    public static final String PATH_QUEST = "/quest";
    public static final String PATH_LOGIN = "/login";
    public static final String PATH_REGISTRATION = "/registration";


    //view
    public static final String VIEW_REGISTRATION = "registration.jsp";
    public static final String VIEW_BAN = "ban.jsp";
    public static final String VIEW_LOGIN = "login.jsp";
    public static final String VIEW_QUEST = "quest.jsp";
    public static final String VIEW_START = "start.jsp";


    // session attr
    public static final String IS_BAN = "isBan";
    public static final String USER = "user";
    public static final String QUEST = "quest";
    public static final String CURRENT_STAGE_ID = "currentStageId";
    public static final String STAGE_ID = "stageId";


    // request attr
    public static final String ERRORS = "errors";
    public static final String INTRO = "intro";
    public static final String QUEST_NAME = "questName";
    public static final String QUEST_LIST = "questList";
    public static final String STAGE = "stage";


    // context names
    public static final String USER_SERVICE = "userService";
    public static final String LOGIN_VALIDATION_EXECUTOR = "loginValidationExecutor";
    public static final String LOGIN_VALIDATOR = "loginValidator";
    public static final String PASSWORD_VALIDATOR = "passwordValidator";
    public static final String PASSWORD_ENCODER = "passwordEncoder";
    public static final String QUEST_SERVICE = "questService";

}
