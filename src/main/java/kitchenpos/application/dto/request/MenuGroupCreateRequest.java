package kitchenpos.application.dto.request;

import kitchenpos.domain.MenuGroup;

public class MenuGroupCreateRequest {

    private String name;

    public MenuGroupCreateRequest() {
    }

    public MenuGroup toMenuGroup() {
        return new MenuGroup(null, name);
    }

    public String getName() {
        return name;
    }
}