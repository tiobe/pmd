---
title: PMD Release Notes
permalink: pmd_release_notes.html
keywords: changelog, release notes
---

## {{ site.pmd.date }} - {{ site.pmd.version }}

The PMD team is pleased to announce PMD {{ site.pmd.version }}.

This is a {{ site.pmd.release_type }} release.

{% tocmaker is_release_notes_processor %}

### New and noteworthy

#### SARIF Format

PMD now supports the [Static Analysis Results Interchange Format (SARIF)](https://www.oasis-open.org/committees/tc_home.php?wg_abbrev=sarif)
as an additional report format. Just use the [command line parameter](pmd_userdocs_cli_reference.html#format) `-format sarif` to select it.
SARIF is an OASIS standard format for static analysis tools.
PMD creates SARIF JSON files in [SARIF version 2.1.0](https://docs.oasis-open.org/sarif/sarif/v2.1.0/sarif-v2.1.0.html).
An example report can be found in the documentation in [Report formats for PMD](pmd_userdocs_report_formats.html#sarif).

#### CPD

*   The C++ module now supports the new option [`--ignore-literal-sequences`](https://pmd.github.io/latest/pmd_userdocs_cpd.html#-ignore-literal-sequences),
    which can be used to avoid detection of some uninteresting clones. This options has been
    introduced with PMD 6.30.0 for C# and is now available for C++ as well. See [#2963](https://github.com/pmd/pmd/pull/2963).

#### New Rules

*   The new Apex rule {% rule "apex/errorprone/OverrideBothEqualsAndHashcode" %} brings the well known Java rule
    to Apex. In Apex the same principle applies: `equals` and `hashCode` should always be overridden
    together to ensure collection classes such as Maps and Sets work as expected.

*   The new Visualforce rule {% rule "vf/security/VfHtmlStyleTagXss" %} checks for potential XSS problems
    when using `<style>` tags on Visualforce pages.

#### Deprecated rules

*   java-performance
    *   {% rule "java/performance/AvoidUsingShortType" %}: arithmetic on shorts is not significantly
        slower than on ints, whereas using shorts may provide significant memory savings in arrays.
    *   {% rule "java/performance/SimplifyStartsWith" %}: the suggested code transformation has an
        insignificant performance impact, and decreases readability.

### Fixed Issues

*   core
    *   [#2953](https://github.com/pmd/pmd/issues/2953): \[core] Support SARIF JSON Format
    *   [#2970](https://github.com/pmd/pmd/issues/2970): \[core] PMD 6.30.0 release is not reproducible
    *   [#2994](https://github.com/pmd/pmd/pull/2994): \[core] Fix code climate severity strings
*   java-bestpractices
    *   [#575](https://github.com/pmd/pmd/issues/575): \[java] LiteralsFirstInComparisons should consider constant fields
    *   [#2454](https://github.com/pmd/pmd/issues/2454): \[java] UnusedPrivateMethod violation for disabled class in 6.23.0
    *   [#2833](https://github.com/pmd/pmd/issues/2833): \[java] NPE in UseCollectionIsEmptyRule with enums
    *   [#2876](https://github.com/pmd/pmd/issues/2876): \[java] UnusedPrivateField cannot override ignored annotations property
    *   [#2957](https://github.com/pmd/pmd/issues/2957): \[java] Ignore unused declarations that have special name
*   java-codestyle
    *   [#2960](https://github.com/pmd/pmd/issues/2960): \[java] Thread issue in MethodNamingConventionsRule
*   java-design
    *   [#3006](https://github.com/pmd/pmd/issues/3006): \[java] NPE in SingularFieldRule with concise resource syntax
*   java-errorprone
    *   [#2976](https://github.com/pmd/pmd/issues/2976): \[java] CompareObjectsWithEquals: FP with array.length
    *   [#2977](https://github.com/pmd/pmd/issues/2977): \[java] 6.30.0 introduces new false positive in CloseResource rule?
    *   [#2979](https://github.com/pmd/pmd/issues/2979): \[java] UseEqualsToCompareStrings: FP with "var" variables
    *   [#3004](https://github.com/pmd/pmd/issues/3004): \[java] UseEqualsToCompareStrings false positive with PMD 6.30.0
    *   [#3062](https://github.com/pmd/pmd/issues/3062): \[java] CloseResource FP with reassigned stream
*   java-performance
    *   [#2296](https://github.com/pmd/pmd/issues/2296): \[java] Deprecate rule AvoidUsingShortType
    *   [#2740](https://github.com/pmd/pmd/issues/2740): \[java] Deprecate rule SimplifyStartsWith
    *   [#3088](https://github.com/pmd/pmd/issues/3088): \[java] AvoidInstantiatingObjectsInLoops - false positive with Collections
*   vf-security
    *   [#3081](https://github.com/pmd/pmd/issues/3081): \[vf] VfUnescapeEl: Inherently un-XSS-able built-in functions trigger false positives

### API Changes

#### Deprecated API

*   {% jdoc xml::lang.xml.rule.AbstractDomXmlRule %}
*   {% jdoc xml::lang.wsdl.rule.AbstractWsdlRule %}
*   A few methods of {% jdoc xml::lang.xml.rule.AbstractXmlRule %}

#### Experimental APIs

*   The method {% jdoc !!core::lang.ast.GenericToken#getKind() %} has been added as experimental. This
    unifies the token interface for both JavaCC and Antlr. The already existing method
    {% jdoc !!core::cpd.token.AntlrToken#getKind() %} is therefore experimental as well. The
    returned constant depends on the actual language and might change whenever the grammar
    of the language is changed.

### External Contributions

*   [#2666](https://github.com/pmd/pmd/pull/2666): \[swift] Manage swift5 string literals - [kenji21](https://github.com/kenji21)
*   [#2959](https://github.com/pmd/pmd/pull/2959): \[apex] New Rule: override equals and hashcode rule - [recdevs](https://github.com/recdevs)
*   [#2963](https://github.com/pmd/pmd/pull/2963): \[cpp] Add option to ignore sequences of literals - [Maikel Steneker](https://github.com/maikelsteneker)
*   [#2964](https://github.com/pmd/pmd/pull/2964): \[cs] Update C# grammar for additional C# 7 and C# 8 features - [Maikel Steneker](https://github.com/maikelsteneker)
*   [#2965](https://github.com/pmd/pmd/pull/2965): \[cs] Improvements for ignore sequences of literals functionality - [Maikel Steneker](https://github.com/maikelsteneker)
*   [#2968](https://github.com/pmd/pmd/pull/2968): \[java] NPE in UseCollectionIsEmptyRule with enums - [foxmason](https://github.com/foxmason)
*   [#2983](https://github.com/pmd/pmd/pull/2983): \[java] LiteralsFirstInComparisons should consider constant fields - [Ozan Gulle](https://github.com/ozangulle)
*   [#2994](https://github.com/pmd/pmd/pull/2994): \[core] Fix code climate severity strings - [Vincent Maurin](https://github.com/vmaurin)
*   [#3005](https://github.com/pmd/pmd/pull/3005): \[vf] \[New Rule] Handle XSS violations that can occur within Html Style tags - [rmohan20](https://github.com/rmohan20)
*   [#3073](https://github.com/pmd/pmd/pull/3073): \[core] Include SARIF renderer - [Manuel Moya Ferrer](https://github.com/mmoyaferrer)
*   [#3084](https://github.com/pmd/pmd/pull/3084): \[vf] VfUnescapeEl false-positive with builtin functions - [Josh Feingold](https://github.com/jfeingold35)

### Stats
* 116 commits
* 40 closed tickets & PRs
* Days since last release: 49

{% endtocmaker %}

