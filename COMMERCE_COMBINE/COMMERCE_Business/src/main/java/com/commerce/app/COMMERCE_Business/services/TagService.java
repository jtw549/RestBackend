package com.commerce.app.COMMERCE_Business.services;

import com.commerce.app.COMMERCE_Business.events.Tags.AddTagEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.DeleteTagEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.TagAddedEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.TagDeletedEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.TagUpdatedEvent;
import com.commerce.app.COMMERCE_Business.events.Tags.UpdateTagEvent;

public interface TagService {
	public TagAddedEvent addTag(AddTagEvent addTagEvent);
	public TagDeletedEvent deleteTag(DeleteTagEvent deleteTagEvent);
	public TagUpdatedEvent updateTag(UpdateTagEvent updateTagEvent);
}
