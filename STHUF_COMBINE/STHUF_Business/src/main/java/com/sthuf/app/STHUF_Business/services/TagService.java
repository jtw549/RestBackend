package com.sthuf.app.STHUF_Business.services;

import com.sthuf.app.STHUF_Business.events.Tags.AddTagEvent;
import com.sthuf.app.STHUF_Business.events.Tags.DeleteTagEvent;
import com.sthuf.app.STHUF_Business.events.Tags.TagAddedEvent;
import com.sthuf.app.STHUF_Business.events.Tags.TagDeletedEvent;
import com.sthuf.app.STHUF_Business.events.Tags.TagUpdatedEvent;
import com.sthuf.app.STHUF_Business.events.Tags.UpdateTagEvent;

public interface TagService {
	public TagAddedEvent addTag(AddTagEvent addTagEvent);
	public TagDeletedEvent deleteTag(DeleteTagEvent deleteTagEvent);
	public TagUpdatedEvent updateTag(UpdateTagEvent updateTagEvent);
}
