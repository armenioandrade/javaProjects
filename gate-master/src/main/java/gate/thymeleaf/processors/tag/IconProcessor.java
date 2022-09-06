package gate.thymeleaf.processors.tag;

import gate.annotation.Color;
import gate.annotation.Icon;
import gate.thymeleaf.ELExpression;
import gate.type.Attributes;
import gate.util.Icons;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.IElementTagStructureHandler;

@ApplicationScoped
public class IconProcessor extends TagProcessor
{

	@Inject
	ELExpression expression;

	public IconProcessor()
	{
		super("icon");
	}

	@Override
	public void process(ITemplateContext context, IProcessableElementTag element, IElementTagStructureHandler handler)
	{
		Attributes attributes = Stream.of(element.getAllAttributes())
			.collect(Collectors.toMap(e -> e.getAttributeCompleteName(),
				e -> e.getValue(), (a, b) -> a, Attributes::new));

		var type = Optional.ofNullable(attributes.remove("type")).map(e -> (String) e).map(expression::evaluate).orElse(null);
		var empty = Optional.ofNullable(attributes.remove("empty")).map(e -> (String) e).map(expression::evaluate).orElse(null);

		if (type == null)
			type = empty;

		if (!attributes.containsKey("style"))
			Color.Extractor.extract(type)
				.ifPresent(e -> attributes.put("style", "color: " + e));

		Icons.Icon icon = Icon.Extractor.extract(type).orElse(Icons.UNKNOWN);

		if (icon.getCode().length() == 1)
			attributes.put("c", "c");

		handler.replaceWith("<i " + attributes + ">" + icon + "</i>", false);
	}

}
