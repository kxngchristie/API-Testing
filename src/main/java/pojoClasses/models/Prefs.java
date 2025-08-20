package pojoClasses.models;

import java.util.ArrayList;

public class Prefs {

    // Public no-argument constructor
    public Prefs() {
        // This is a default constructor required for JSON deserialization
    }

    // Fields representing the preferences of a board in Trello
    public String permissionLevel;
    public boolean hideVotes;
    public String voting;
    public String comments;
    public String invitations;
    public boolean selfJoin;
    public boolean cardCovers;
    public boolean showCompleteStatus;
    public boolean cardCounts;
    public boolean isTemplate;
    public String cardAging;
    public boolean calendarFeedEnabled;
    public ArrayList<Object> hiddenPluginBoardButtons;
    public ArrayList<SwitcherView> switcherViews;
    public Object autoArchive;
    public String background;
    public String backgroundColor;
    public Object backgroundDarkColor;
    public Object backgroundImage;
    public Object backgroundDarkImage;
    public Object backgroundImageScaled;
    public boolean backgroundTile;
    public String backgroundBrightness;
    public Object sharedSourceUrl;
    public String backgroundBottomColor;
    public String backgroundTopColor;
    public boolean canBePublic;
    public boolean canBeEnterprise;
    public boolean canBeOrg;
    public boolean canBePrivate;
    public boolean canInvite;

    public Prefs(String permissionLevel, boolean hideVotes, String voting, String comments, String invitations, boolean selfJoin,
                 boolean cardCovers, boolean showCompleteStatus, boolean cardCounts, boolean isTemplate, String cardAging,
                 boolean calendarFeedEnabled, ArrayList<Object> hiddenPluginBoardButtons, ArrayList<SwitcherView> switcherViews,
                 Object autoArchive, String background, String backgroundColor, Object backgroundDarkColor, Object backgroundImage,
                 Object backgroundDarkImage, Object backgroundImageScaled, boolean backgroundTile, String backgroundBrightness,
                 Object sharedSourceUrl, String backgroundBottomColor, String backgroundTopColor, boolean canBePublic, boolean canBeEnterprise,
                 boolean canBeOrg, boolean canBePrivate, boolean canInvite) {
        this.permissionLevel = permissionLevel;
        this.hideVotes = hideVotes;
        this.voting = voting;
        this.comments = comments;
        this.invitations = invitations;
        this.selfJoin = selfJoin;
        this.cardCovers = cardCovers;
        this.showCompleteStatus = showCompleteStatus;
        this.cardCounts = cardCounts;
        this.isTemplate = isTemplate;
        this.cardAging = cardAging;
        this.calendarFeedEnabled = calendarFeedEnabled;
        this.hiddenPluginBoardButtons = hiddenPluginBoardButtons;
        this.switcherViews = switcherViews;
        this.autoArchive = autoArchive;
        this.background = background;
        this.backgroundColor = backgroundColor;
        this.backgroundDarkColor = backgroundDarkColor;
        this.backgroundImage = backgroundImage;
        this.backgroundDarkImage = backgroundDarkImage;
        this.backgroundImageScaled = backgroundImageScaled;
        this.backgroundTile = backgroundTile;
        this.backgroundBrightness = backgroundBrightness;
        this.sharedSourceUrl = sharedSourceUrl;
        this.backgroundBottomColor = backgroundBottomColor;
        this.backgroundTopColor = backgroundTopColor;
        this.canBePublic = canBePublic;
        this.canBeEnterprise = canBeEnterprise;
        this.canBeOrg = canBeOrg;
        this.canBePrivate = canBePrivate;
        this.canInvite = canInvite;
    }

    public String getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(String permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public boolean isHideVotes() {
        return hideVotes;
    }

    public void setHideVotes(boolean hideVotes) {
        this.hideVotes = hideVotes;
    }

    public String getVoting() {
        return voting;
    }

    public void setVoting(String voting) {
        this.voting = voting;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getInvitations() {
        return invitations;
    }

    public void setInvitations(String invitations) {
        this.invitations = invitations;
    }

    public boolean isSelfJoin() {
        return selfJoin;
    }

    public void setSelfJoin(boolean selfJoin) {
        this.selfJoin = selfJoin;
    }

    public boolean isCardCovers() {
        return cardCovers;
    }

    public void setCardCovers(boolean cardCovers) {
        this.cardCovers = cardCovers;
    }

    public boolean isShowCompleteStatus() {
        return showCompleteStatus;
    }

    public void setShowCompleteStatus(boolean showCompleteStatus) {
        this.showCompleteStatus = showCompleteStatus;
    }

    public boolean isCardCounts() {
        return cardCounts;
    }

    public void setCardCounts(boolean cardCounts) {
        this.cardCounts = cardCounts;
    }

    public boolean isIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    public String getCardAging() {
        return cardAging;
    }

    public void setCardAging(String cardAging) {
        this.cardAging = cardAging;
    }

    public boolean isCalendarFeedEnabled() {
        return calendarFeedEnabled;
    }

    public void setCalendarFeedEnabled(boolean calendarFeedEnabled) {
        this.calendarFeedEnabled = calendarFeedEnabled;
    }

    public ArrayList<Object> getHiddenPluginBoardButtons() {
        return hiddenPluginBoardButtons;
    }

    public void setHiddenPluginBoardButtons(ArrayList<Object> hiddenPluginBoardButtons) {
        this.hiddenPluginBoardButtons = hiddenPluginBoardButtons;
    }

    public ArrayList<SwitcherView> getSwitcherViews() {
        return switcherViews;
    }

    public void setSwitcherViews(ArrayList<SwitcherView> switcherViews) {
        this.switcherViews = switcherViews;
    }

    public Object getAutoArchive() {
        return autoArchive;
    }

    public void setAutoArchive(Object autoArchive) {
        this.autoArchive = autoArchive;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Object getBackgroundDarkColor() {
        return backgroundDarkColor;
    }

    public void setBackgroundDarkColor(Object backgroundDarkColor) {
        this.backgroundDarkColor = backgroundDarkColor;
    }

    public Object getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Object backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Object getBackgroundDarkImage() {
        return backgroundDarkImage;
    }

    public void setBackgroundDarkImage(Object backgroundDarkImage) {
        this.backgroundDarkImage = backgroundDarkImage;
    }

    public Object getBackgroundImageScaled() {
        return backgroundImageScaled;
    }

    public void setBackgroundImageScaled(Object backgroundImageScaled) {
        this.backgroundImageScaled = backgroundImageScaled;
    }

    public boolean isBackgroundTile() {
        return backgroundTile;
    }

    public void setBackgroundTile(boolean backgroundTile) {
        this.backgroundTile = backgroundTile;
    }

    public String getBackgroundBrightness() {
        return backgroundBrightness;
    }

    public void setBackgroundBrightness(String backgroundBrightness) {
        this.backgroundBrightness = backgroundBrightness;
    }

    public Object getSharedSourceUrl() {
        return sharedSourceUrl;
    }

    public void setSharedSourceUrl(Object sharedSourceUrl) {
        this.sharedSourceUrl = sharedSourceUrl;
    }

    public String getBackgroundBottomColor() {
        return backgroundBottomColor;
    }

    public void setBackgroundBottomColor(String backgroundBottomColor) {
        this.backgroundBottomColor = backgroundBottomColor;
    }

    public String getBackgroundTopColor() {
        return backgroundTopColor;
    }

    public void setBackgroundTopColor(String backgroundTopColor) {
        this.backgroundTopColor = backgroundTopColor;
    }

    public boolean isCanBePublic() {
        return canBePublic;
    }

    public void setCanBePublic(boolean canBePublic) {
        this.canBePublic = canBePublic;
    }

    public boolean isCanBeEnterprise() {
        return canBeEnterprise;
    }

    public void setCanBeEnterprise(boolean canBeEnterprise) {
        this.canBeEnterprise = canBeEnterprise;
    }

    public boolean isCanBeOrg() {
        return canBeOrg;
    }

    public void setCanBeOrg(boolean canBeOrg) {
        this.canBeOrg = canBeOrg;
    }

    public boolean isCanBePrivate() {
        return canBePrivate;
    }

    public void setCanBePrivate(boolean canBePrivate) {
        this.canBePrivate = canBePrivate;
    }

    public boolean isCanInvite() {
        return canInvite;
    }

    public void setCanInvite(boolean canInvite) {
        this.canInvite = canInvite;
    }
}